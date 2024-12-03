package vn.toilamdev.bookmarket.service.auth;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.UserService;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    protected void clearAuthenticationAttributes(HttpServletRequest request, Authentication authentication) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        User currentUser = this.userService.getUserByEmail(authentication.getName());
        if (currentUser != null) {
            session.setAttribute("username", currentUser.getUsername());
            session.setAttribute("avatar", currentUser.getAvatar());
            session.setAttribute("roleName", currentUser.getRole().getName());
            session.setAttribute("id", currentUser.getId());
            session.setAttribute("cartCount", currentUser.getCart().getCartItems().size());
            session.setAttribute("cartId", currentUser.getCart().getId());
            session.setAttribute("totalCartPrice", currentUser.getCart().getTotalPrice());
        }

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String targetUrl = "";

        if (roles.contains("ROLE_USER")) {
            targetUrl = "/";
        } else {
            targetUrl = "/admin";
        }

        if (response.isCommitted()) {
            return;
        }

        this.redirectStrategy.sendRedirect(request, response, targetUrl);
        clearAuthenticationAttributes(request, authentication);
    }

}
