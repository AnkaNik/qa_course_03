**_Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
Если может - приведите пример, когда._**

Да, между двумя записями существует разница.
Поиск приведет к разным элементам: в первом случае будет осуществляться поиск по детям div родителя h1. во втором случае
будет искать первый div внутри элемента h1

<h1>Home page
  
<div>My favorite place</div>
<div>Contacts</div>

</h1>

$("h1 div")  найдет два элемента My favorite place и Contacts

$("h1").$("div") найдет  My favorite place
