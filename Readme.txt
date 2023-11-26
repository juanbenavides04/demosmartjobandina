http://localhost:8080/swagger-ui/index.html#/usuario-controller/guardar

-Al ejecutar el proyecto se creara una lista de registros

Ingresar o guardar metodo POST
http://localhost:8080/api/guardar

{
     
        "name": "name 10",
        "email": "email_1d0@gmail.com",
        "password": "password_10",
        "isactive": true,
        "phones": [
                {
                "number": "1234567",
                "citycode": "3",
                "contrycode": "57"
                }
        ]

}

-Mostrar lista de registros metodo GET
http://localhost:8080/api/mostrarlista

-Modificar registros metodo POST
http://localhost:8080/api/modificar

{
    "id": 1,
    "name": "name modificado",
    "email": "email_3@gmail.com",
    "password": "password_3",
    "isactive": false,
    "phones": [
        {
            "number": "1234567",
            "citycode": "3",
            "contrycode": "57"
        }
    ]
}

-Eliminar registros metodo GET
http://localhost:8080/api/mostrar/11