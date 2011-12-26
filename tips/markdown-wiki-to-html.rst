markdown wiki to html
=====================

checkout a wiki that uses markdown::

        git clone https://github.com/harrah/xsbt.wiki

cd to the wiki and::

        for i in $(find . -name '*.md'); 
        do 
                f=$(basename $i .md); 
                d=$(dirname $i); 
                p="$d/$f"; 
                echo "processing $p"; 
                markdown $p.md > $p.html; 
        done
