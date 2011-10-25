custom
======

* ,a attach file in vim
* gi go inbox
* gs go sent
* gd go drafts

basic
=====

* m       compose         compose a new message
* r       reply           reply to sender
* s       save-message    save/move message/attachment to a mailbox/file                                                                  
* g       group-reply     reply to all recipients
* L       list-reply      reply to mailing list address
* f       forward         forward message
* b       bounce          bounce (remail) message
* c-T complete-query  complete address with query
* c-G abort
* N  mark as new (unread)

* j or Down       next-entry      move to the next entry
* k or Up         previous-entry  move to the previous entry
* z or PageDn     page-down       go to the next page
* Z or PageUp     page-up         go to the previous page
* = or Home       first-entry     jump to the first entry
* * or End        last-entry      jump to the last entry
* q               quit            exit the current menu
* ?               help            list all keybindings for the current menu

composing
=========

* a       attach-file             attach a file
* A       attach-message          attach message(s) to the message
* d       edit-description        edit description on attachment
* D       detach-file             detach a file
* t       edit-to                 edit the To field
* ESC f   edit-from               edit the From field
* r       edit-reply-to           edit the Reply-To field
* c       edit-cc                 edit the Cc field
* b       edit-bcc                edit the Bcc field
* y       send-message            send the message
* s       edit-subject            edit the Subject
* f       edit-fcc                specify an Fcc mailbox
* P       postpone-message        postpone this message until later
* q       quit                    quit (abort) sending the message
* w       write-fcc               write the message to a folder
* i       ispell                  check spelling (if available on your system)

inbox
=====

* c               change to a different mailbox
* ESC c           change to a folder in read-only mode
* C               copy the current message to another mailbox
* D               delete messages matching a pattern
* d               delete the current message
* F               mark as important
* l               show messages matching a pattern
* N               mark message as new
* o               change the current sort method
* O               reverse sort the mailbox
* q               save changes and exit
* s               save-message
* T               tag messages matching a pattern
* t               toggle the tag on a message
* ESC t           toggle tag on entire message thread
* U               undelete messages matching a pattern
* u               undelete-message
* v               view-attachments
* x               abort changes and exit
* <Return>        display-message
* <Tab>           jump to the next new message
* @               show the author's full e-mail address
* $               save changes to mailbox
* /               search
* ESC /           search-reverse
* ^L              clear and redraw the screen
* ^T              untag messages matching a pattern

imap
====

* u unsubscribe from imap folder (on the y menu)
* s subscribe to imap folder (on the y menu)
