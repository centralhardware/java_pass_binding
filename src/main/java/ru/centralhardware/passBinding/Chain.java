package ru.centralhardware.passBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * create chain of methods and evaluate after call ${@link Chain#e()} or ${@link Chain#evaluate()}
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class Chain {

    private final List<Function> functions;

    /**
     * create Chain with first methods that don't have parameter (existing param will be ignore)
     * @param method methods without param
     * @param <T> instance of Chain
     */
    private  <T> Chain(Supplier<T> method){
        functions = new ArrayList<>();
        functions.add(it -> method.get());
    }


    /**
     * create Chain instance with first methods
     * @param method methods without parameter
     * @return instance of Chain
     */
    public static Chain of(Supplier method){
        return new Chain(method);
    }

    /**
     * alias for ${@link Chain#Chain(Supplier)}
     */
    public <R, T> Chain c(Function<? super T, ? extends R> method) {
        return chain(method);
    }

    /**
     * alias for ${@link Chain#evaluate()}
     */
    public Object e() {
        return evaluate();
    }

    /**
     * add methods to chain
     * @param method giving methods
     * @param <R> result type
     * @param <T> param type
     * @return instance of ${@link Chain}
     */
    public <R, T> Chain chain(Function<? super T, ? extends R> method){
        functions.add(method);
        return this;
    }

    /**
     * @return result of calculated chain of methods
     */
    public Object evaluate(){
        Object result = null;
        for (Function method : functions){
            result = method.apply(result);
        }
        return result;
    }

}