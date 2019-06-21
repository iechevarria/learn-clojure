;; 1) Nothing but the Truth
(= true true)


;; 2) Simple Math
(= (- 10 (* 2 3)) 4)


;; 3) Intro to Strings
(= "HELLO WORLD" (.toUpperCase "hello world"))


;; 4) Intro to Lists
(= (list :a :b :c) '(:a :b :c))


;; 5) Lists: conj
(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))


;; 6) Intro to Vectors
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))


;; 7) Vectors: conj
(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2 3] 4))


;; 8) Intro to Sets
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))


;; 9) Sets: conj
(= #{1 2 3 4} (conj #{1 4 3} 2))


;; 10) Intro to Maps
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))


;; 11) Maps: conj
(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))


;; 12) Intro to Sequences
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))


;; 13) Sequences: rest
(= [20 30 40] (rest [10 20 30 40]))


;; 14) Intro to Functions
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))


;; 15) Double Down
(= (* 2 2) 4)
(= (* 2 3) 6)
(= (* 2 11) 22)
(= (* 2 7) 14)


;; 16) Hello World
(= ((fn [name] (str "Hello, " name "!")) "Dave") "Hello, Dave!")
(= ((fn [name] (str "Hello, " name "!")) "Jenn") "Hello, Jenn!")
(= ((fn [name] (str "Hello, " name "!")) "Rhea") "Hello, Rhea!")


;; 17) Sequences: map
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))


;; 18) Sequences: filter
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))


;; 19) Last Element
(defn my-last [iter] (nth iter (- (count iter) 1)))

(= ((fn [iter] (nth iter (- (count iter) 1))) [1 2 3 4 5]) 5)
(= ((fn [iter] (nth iter (- (count iter) 1))) '(5 4 3)) 3)
(= ((fn [iter] (nth iter (- (count iter) 1))) ["b" "c" "d"]) "d")


;; 20) Penultimate Element
(defn my-penultimate [iter] (nth iter (- (count iter) 2)))

(= ((fn [iter] (nth iter (- (count iter) 2))) (list 1 2 3 4 5)) 4)
(= ((fn [iter] (nth iter (- (count iter) 2))) ["a" "b" "c"]) "b")
(= ((fn [iter] (nth iter (- (count iter) 2))) [[1 2] [3 4]]) [1 2])
