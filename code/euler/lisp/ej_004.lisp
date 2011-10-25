(defun is-palindrome (num)
    (setf str (format nil "~a" num))
    (equal str (reverse str)))

(defun get-largest-palindrome ()
 (progn
   (setf temp 0)
   (loop for i from 999 downto 0 do
     (loop for j from i downto 0 do
       (progn
	(setq value (* i j))
         (if (and (is-palindrome value) (> value temp))
           (setq temp value)))))
    temp))

(print (get-largest-palindrome))
