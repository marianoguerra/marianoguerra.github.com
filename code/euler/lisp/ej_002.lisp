(defun fibonacci-step (one two)
  (list two  (+ one two)))

(defun calculate-helper (one two limit accum)
  (cond ((> two limit) accum)
         (T (let ((result (fibonacci-step one two)))
		(let ((new-one (car result))
		     (new-two (cadr result)))

		     (if (eq (rem new-two 2) 0)
			(calculate-helper new-one new-two limit (+ accum new-two))
			(calculate-helper new-one new-two limit accum)))))))

(defun calculate (limit) (calculate-helper 0 1 limit 0))

(defun print-result () (print (calculate 4000000)))
