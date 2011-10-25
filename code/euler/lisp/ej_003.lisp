(defun factors-helper (value limit)
  (loop for factor from 2 when (= (rem value factor) 0) collect factor while (< factor limit)))

(defun factors (value) (factors-helper value (truncate (sqrt value))))

(defun print-results () (print (last (factors 600851475143))))

(print-results)
