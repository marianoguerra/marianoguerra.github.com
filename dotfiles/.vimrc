au BufRead,BufNewFile *.py,*pyw,*js,*.json,*.php,*.erl,*.fn,*.ifn,*.yrl,*.xrl set shiftwidth=4
au BufRead,BufNewFile *.c,*.h set shiftwidth=4
set backspace=indent,eol,start

au BufRead,BufNewFile *py,*pyw,*.php,*.c,*.h,*js,*.json,*.erl,*.fn,*.ifn,*.yrl,*.xrl set tabstop=4
au BufRead,BufNewFile *html,*xul,*htm,*xml,*xhtml,*css set tabstop=1 sw=1 expandtab 

au BufRead,BufNewFile *.fn source ~/.vim/syntax/efene.vim
au BufRead,BufNewFile *.ifn source ~/.vim/syntax/efene.vim
au BufRead,BufNewFile *.fn set filetype=efene
au BufRead,BufNewFile *.ifn set filetype=efene
au BufRead,BufNewFile *.xul set filetype=xml
au BufRead,BufNewFile *.yrl source /usr/share/vim/vim72/syntax/erlang.vim
au BufRead,BufNewFile *.xrl source /usr/share/vim/vim72/syntax/erlang.vim
au BufRead,BufNewFile *.json source /usr/share/vim/vim72/syntax/javascript.vim
" Replace tabs with the equivalent number of spaces.
" Also have an autocmd for Makefiles since they require hard tabs.
" Python: yes
" C: no
" Makefile: no
au BufRead,BufNewFile *.py,*.pyw,*.js,*.json,*.php,*.erl,*.fn,*.ifn,*.yrl,*.xrl set expandtab
au BufRead,BufNewFile *.c,*.h set noexpandtab
au BufRead,BufNewFile Makefile* set noexpandtab

" Use the below highlight group when displaying bad whitespace is desired
highlight BadWhitespace ctermbg=red guibg=red

" Display tabs at the beginning of a line in Python mode as bad.
au BufRead,BufNewFile *.py,*.pyw,*.js,*.json,*.css,*.php,*.erl,*.fn,*.ifn,*.yrl,*.xrl match BadWhitespace /^\t\+/
" Make trailing whitespace be flagged as bad.
au BufRead,BufNewFile *.py,*.pyw,*.c,*.h,*.js,*.json,*.css,*.php,*.erl,*.fn,*.ifn,*.yrl,*.xrl match BadWhitespace /\s\+$/

" Wrap text after a certain number of characters
" Python: 79 
" C: 79
au BufRead,BufNewFile *.py,*.pyw,*.c,*.h,*.php,*.erl,*.fn,*.ifn,*.yrl,*.xrl set textwidth=79

augroup golang
  au!
  au BufRead,BufNewFile *.go set filetype=go
  au FileType go set noexpandtab
  au FileType go set smartindent
  au FileType go set equalprg=gofmt
augroup END

" Turn off settings in 'formatoptions' relating to comment formatting.
" - c : do not automatically insert the comment leader when wrapping based on
"    'textwidth'
" - o : do not insert the comment leader when using 'o' or 'O' from command mode
" - r : do not insert the comment leader when hitting <Enter> in insert mode
" Python: not needed
" C: prevents insertion of '*' at the beginning of every line in a comment
au BufRead,BufNewFile *.c,*.h set formatoptions-=c formatoptions-=o formatoptions-=r

" Use UNIX (\n) line endings.
" Only used for new files so as to not force existing files to change their
" line endings.
" Python: yes
" C: yes
au BufNewFile *.py,*.pyw,*.c,*.h,*.erl,*.php,*.html,*.css,*.fn,*.ifn,*.yrl,*.xrl set fileformat=unix


" ----------------------------------------------------------------------------
" The following section contains suggested settings.  While in no way required
" to meet coding standards, they are helpful.

" Set the default file encoding to UTF-8: ``set encoding=utf-8``

" Puts a marker at the beginning of the file to differentiate between UTF and
" UCS encoding (WARNING: can trick shells into thinking a text file is actually
" a binary file when executing the text file): ``set bomb``

" For full syntax highlighting:
let python_highlight_all=1
syntax on

" Automatically indent based on file type: 
filetype indent on
filetype on            " enables filetype detection
filetype plugin on     " enables filetype specific plugins
" Keep indentation level from previous line: 
set autoindent

" Folding based on indentation: 
" set foldmethod=indent

" -----------------------------------------------------------------------------
" otra config

" shows the match while typing
set incsearch
" case insensitive search
set ignorecase

"Set magic on
set magic

"No sound on errors.
set noerrorbells
set novisualbell
"set t_vb=

"show matching bracets
set showmatch

"How many tenths of a second to blink
"set mat=2

"Highlight search things
set hlsearch

"Turn backup off
set nobackup

map <F6> <Esc>:setlocal spell spelllang=en_gb<CR>
map <F7> <Esc>:setlocal nospell<CR>
map <F8> <Esc>z=
map <F9> <Esc>]s

set wildmode=longest,list
