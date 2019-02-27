<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Products</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
        html {
            overflow-x: hidden;
            margin-right: calc(-1 * (100vw - 100%));
        }
        * { margin: 0;
            padding: 0;
        }
        .imgbox {
            display: grid;
            height: 100%;
        }
        .center-fit {
            max-width: 100%;
            max-height: 100vh;
            margin: auto;
        }

    </style>
</head>
<body>
<img class="center-fit"
     src="https://lh3.googleusercontent.com/plFqB7Q75GE3wcrcPR5oSTXFUQLra-Z4YIYQY6V1kJ4MMgFKzh49JVy8KQdJlgsN43B2d0Mmc1uIkIwgOGdN-r8scYSbpXah5_Eg53JSJRzgxw9pzvet8n61G78D8c-dRPPyjSRZNSihSaIIygfn-7rR-7wGVm7UndyjXWUyZ9Gw4KhG5ZqANpS0BYixmZmPVbdrxgMSYcmxHascX-0f_KmLoILM_oo6MINmLYIJTT1HqJ0LKW9cR12Jn4_kXIcE9iKxG-OtgQ9ynnI_2HRO385n5JRbRPMWcFCws4OvhXlX7NH88KSiyph2r7mfpDyswMUEZ9Kn-jUp-cKbeeg-92lrBHgnXuncfY-XqaepFlNXYX9wqppS00kzvsKaODt0T30yeQgDL8_90gHGSATQmMpUa87D_AhsFqP6D-5SRKRXwFzZkbb41yK1B8LCTx3JcUP3m6StWPhQMFWDC43QsZeLI41tKLt8ycJFqHu0AncvM0qxzs6Z-EQS0LIyGgaJXdBXostPM3jPaPOXMJ1IylydNSUNLhTE7KgcyZoUwbHTD7GzRPzFH29Dvl2zz_ATLqUT6ay_4qDStD70f0XtMCICOwktQSyJ2bCwEr7zuoIcPVMsBIQn0_baIXFB-WEwwk4aGuNtdvYoGwJdtGvF31RgGMAf-CZftKP6P7aGO20W-_3M_mKVIaph5vPHjBy5vBjShzvSdU2jpumDHL_waHu2PA=w1901-h172-no"
     alt="">
<b>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="product/add">Add product</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout">Log out</a>
            </li>
        </ul>
    </nav>
</b>

<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
        <th scope="col">Price</th>
        <th>Action</th>
        <th>Action</th>
    </tr>
    </thead>

    <#list products as product>
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.price}</td>
                <th>
                    <form action="/cart/${product.id}" method=post>
                        <input type=submit value="To Cart">
                    </form>
                </th>
        <th>
            <form action="/product/delete" method=post>
                <input type=text name=id style="display: none" value="${product.id}">
                <input type=submit value=delete>
            </form>
        </th>
        <th>
            <form action="/product/edit" method=get>
                <input type=text name=id style="display: none" value="${product.id}">
                <input type=submit value=update>
            </form>
        </th>
    </tr>
</#list>

</table>

</body>
</html>