(defun is-multiple-from-11-to-18 (value)
 (= (loop for i from 18 downto 11 by 1
       while (= (mod value i) 0) finally (return i)) 10))

(defun first-multiple-from-1-to-20 ()
 (loop for i from 380 by 380
  while (not (is-multiple-from-11-to-18 i))
  finally (return i)))

(print (first-multiple-from-1-to-20))
