(defun multiple-of-3-or-5 (value)
  (or (eq (rem value 3) 0)
      (eq (rem value 5) 0))
)

(defun calculate-helper (value accum limit)
  (cond ((= value limit)
           accum)
	 ((multiple-of-3-or-5 value)
           (calculate-helper (+ value 1) (+ accum value) limit))
         (T
          (calculate-helper (+ value 1) accum limit))
  )
)

(defun calculate () (calculate-helper 0 0 1000))

(defun print-result ()
  (print (calculate)))

(print-result)


