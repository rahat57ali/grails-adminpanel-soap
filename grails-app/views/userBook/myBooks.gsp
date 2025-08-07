<h1>Books You Purchased</h1>

<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Price</th>
    </tr>
    <g:each in="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.authorName}</td>
            <td>${book.price}</td>
        </tr>
    </g:each>
</table>

<g:if test="${flash.message}">
    <p style="color: green">${flash.message}</p>
</g:if>
