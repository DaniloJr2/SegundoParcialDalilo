<%
    String option = request.getParameter("option");
%>

<ul class="nav nav-tabs">
    
    <li class="nav-item">
        <a class="nav-link <%=(option.equals("productos") ? "active" : "")%>" href="ProductosControlador">Productos</a>
    </li>
</ul>
