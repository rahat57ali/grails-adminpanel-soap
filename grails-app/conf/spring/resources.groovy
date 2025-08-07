import proj.assignment.soap.UserDetailsServiceImpl

beans = {
    userDetailsServiceImpl(UserDetailsServiceImpl) {
        userService = ref('userService')
    }
}