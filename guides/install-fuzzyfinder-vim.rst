install fuzzyfinder in vim
==========================

::

        wget https://bitbucket.org/ns9tks/vim-fuzzyfinder/get/tip.zip
        wget https://bitbucket.org/ns9tks/vim-l9/get/tip.zip

        unzip ns9tks-vim-fuzzyfinder-tip.zip 
        cd ns9tks-vim-fuzzyfinder-tip/
        cp -r . ~/.vim/

        unzip ns9tks-vim-l9-tip.zip 
        cd ns9tks-vim-l9-tip/
        cp -r . ~/.vim/

               
add mappings to vim
-------------------

this are mine::

        nnoremap ,s     :FufFile<CR>
