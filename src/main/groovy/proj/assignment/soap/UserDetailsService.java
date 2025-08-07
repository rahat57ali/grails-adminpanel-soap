package proj.assignment.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(
        name = "UserDetailsService",
        targetNamespace = "http://soap.assignment.proj/"
)
interface UserDetailsService {
    @WebMethod(operationName = "getUserDetails")
    UserDetailsResponse getUserDetails(@WebParam(name = "email") String email);
}
