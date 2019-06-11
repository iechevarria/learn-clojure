;; 1) Define a function greet that takes no arguments and prints "Hello".

(defn greet[] println "Hello")



;; 2) Redefine greet using def, first with the fn special form and then with the
;;       #() reader macro.

;; using fn
(def greet (fn [] println "Hello"))

;; using #()
(def greet #(println "Hello"))



;; 3) Define a function greeting which:
;;       - Given no arguments, returns "Hello, World!"
;;       - Given one argument x, returns "Hello, x!"
;;       - Given two arguments x and y, returns "x, y!"

;; Hint use the str function to concatenate strings
(doc str)

(defn greeting
    ([]     (greeting "Hello" "World"))
    ([x]    (greeting "Hello" x))
    ([x, y] (str x ", " y "!")))

;; For testing
(assert (= "Hello, World!" (greeting)))
(assert (= "Hello, Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))



;; 4) Define a function do-nothing which takes a single argument x and returns 
;;      it, unchanged.

(defn do-nothing [x] x)



;; 5) Define a function always-thing which takes any number of arguments, 
;;      ignores all of them, and returns the number 100.

(defn always-thing [& args] 100)



;; 6) Define a function make-thingy which takes a single argument x. It should
;;      return another function, which takes any number of arguments and always
;;      returns x.

(defn make-thingy [x] (fn [& args] x))

;; Tests
(let [n (rand-int Integer/MAX_VALUE)
      f (make-thingy n)]
  (assert (= n (f)))
  (assert (= n (f 123)))
  (assert (= n (apply f 123 (range)))))



;; 7) Define a function triplicate which takes another function and calls it
;;      three times, without any arguments.

(defn triplicate [f] (f) (f) (f))

