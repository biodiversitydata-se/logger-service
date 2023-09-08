package au.org.ala.logger.admin

import au.org.ala.web.AlaSecured

@AlaSecured(value = "ROLE_ADMIN", redirectController = 'logger', redirectAction = 'notAuthorised')
class AdminController {

    def index () {
        // SBDI: for unknown reasons the above annotation doesn't work for this controller
        if(!request.isUserInRole("ROLE_ADMIN"))
            redirect(controller: 'logger', action: 'notAuthorised')

        render(view: "admin")
    }

}
