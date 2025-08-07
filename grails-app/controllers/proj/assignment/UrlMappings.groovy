package proj.assignment

class UrlMappings {
    static mappings = {

        "/user/books"(controller: "userBook", action: "index")
        "/user/my-books"(controller: "userBook", action: "myBooks")
        "/user/buy/$id"(controller: "userBook", action: "buy")
        "/admin/createUser"(controller: "Admin", action: "createUser", method: "POST")




        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

    }
}
