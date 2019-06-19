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



;; 8) Define a function opposite which takes a single argument f. It should
;;      return another function which takes any number of arguments, applies f
;;      on them, and then calls not on the result. The not function in Clojure
;;      does logical negation.

(defn opposite [f]
  (fn ([& args] (not (apply f args)))))



;; 9) Define a function triplicate2 which takes another function and any number
;;      of arguments, then calls that function three times on those arguments.
;;      Re-use the function you defined in the earlier triplicate exercise.

(defn triplicate2 [f & args]
  (triplicate (fn 
    ([] (f))
    ([args] (f args)))))



;; 10) Using the java.lang.Math class (Math/pow, Math/cos, Math/sin, Math/PI), 
;;      demonstrate the following mathematical facts:
;;        - The cosine of pi is -1
;;        - For some x, sin(x)^2 + cos(x)^2 = 1

(assert (= (Math/cos Math/PI) -1.0))

(defn square [number] (* number number))
(def half_pi (/ Math/PI 2))
(assert 
  (= 
    (+(square (Math/sin half_pi))
      (square (Math/cos half_pi))) 
    1.0))



;; 11) Define a function that takes an HTTP URL as a string, fetches that URL
;;      from the web, and returns the content as a string.

;; Hint: Using the java.net.URL class and its openStream method. Then use the
;; Clojure slurp function to get the content as a string.

(import (java.net URL))
(defn http-get [url]
  (slurp (.openStream (URL. url))))

(assert (.contains (http-get "https://www.echevarria.io") "html"))

;; In fact, the Clojure slurp function interprets its argument as a URL first
;; before trying it as a file name. Write a simplified http-get:

(defn http-get [url]
  (slurp url))



;; 12) Define a function one-less-arg that takes two arguments:
;;      - f, a function
;;      - x, a value
;;      and returns another function which calls f on x plus any additional
;;      arguments.

(defn one-less-arg [f x]
  (fn [& args] (apply f x args)))



;; 13) Define a function two-fns which takes two functions as arguments, f and
;;      g. It returns another function which takes one argument, calls g on it,
;;      then calls f on the result, and returns that. That is, your function 
;;      returns the composition of f and g.

(defn two-fns [f g]
  (fn [x] (f (g x))))
