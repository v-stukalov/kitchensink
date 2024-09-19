package demo.springboot.quickstarts.kitchensink.controller;

import demo.springboot.quickstarts.kitchensink.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberFormController.class)
class MemberFormControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService service;

    @Test
    void showMembersForm() throws Exception {
        this.mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("members"))
                .andExpect(model().attributeExists("members"));
    }

    @Test
    void showRegisterForm() throws Exception {
        this.mockMvc
                .perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("member"));
    }

    @Test
    void registerMember() throws Exception {
        this.mockMvc
                .perform(
                        post("/register")
                                .param("name", "Patrick Jane")
                                .param("phoneNumber", "9407074994")
                                .param("email", "pjane@mailinator.com"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"))
                .andExpect(header().string("Location", "/"));
    }

    @Test
    void shouldRejectInvalidPayloadWhenCreatingCustomer() throws Exception {
        this.mockMvc
                .perform(
                        post("/register")
                                .param("name", "Pat1988")
                                .param("phoneNumber", "13")
                                .param("email", "pjane2mailinator.com"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().hasErrors())
                .andExpect(model().attributeHasErrors("member"));
    }
}