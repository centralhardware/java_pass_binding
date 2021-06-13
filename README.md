[![Java CI with Maven](https://github.com/centralhardware/java_pass_binding/actions/workflows/maven.yml/badge.svg)](https://github.com/centralhardware/java_pass_binding/actions/workflows/maven.yml)

java library for function chaining like clojure pass binding

```clojure
(as-> "a" x
      (list 1 x)
      (list 2 x)
      (list 3 x)
      (list 4 x)
      (list 5 x))

;; returns
;; (5 (4 (3 (2 (1 "a")))))
```

example:

```java
Chain.
        of(ChainTest::a).
        c(ChainTest::b).
        c(ChainTest::c).
        e();
```
