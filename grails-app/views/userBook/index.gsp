<h1>Available Books</h1>

<g:if test="${session.user}">
    Welcome, ${session.user.firstName}!
</g:if>


<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    <g:each in="${books}" var="book">
        <tr>
            <td>${book.titleName}</td>
            <td>${book.authorName}</td>
            <td>${book.price}</td>
            <td>
                <g:link controller="userBook" action="buy" id="${book.id}">Buy</g:link>
            </td>
        </tr>
    </g:each>
</table>

<g:if test="${flash.message}">
    <p style="color: green">${flash.message}</p>
</g:if>
