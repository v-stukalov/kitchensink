package demo.springboot.quickstarts.kitchensink.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.springboot.quickstarts.kitchensink.model.Member;
import demo.springboot.quickstarts.kitchensink.service.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@WebMvcTest(controllers = {MemberRestController.class})
class MemberRestControllerTest {
    private final Member memberOne = Member.builder().id(0L).name("Patrick").phoneNumber("9407074994").email("pjane@cbi.gov").build();
    private final Member memberTwo = Member.builder().id(1L).name("Theresa").phoneNumber("4698903245").email("tlisbon@cbi.gov").build();
    private final List<Member> members = Arrays.asList(this.memberOne, this.memberTwo);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    void findAllMembers() throws Exception {
        Mockito.when(this.memberService.findAll()).thenReturn(this.members);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/members"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id")
                        .value(this.memberOne.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id")
                        .value(this.memberTwo.getId()));
        Mockito.verify(this.memberService, Mockito.times(1)).findAll();
    }

    @Test
    void addMember() throws Exception {
        Member newMember = this.members.get(new Random().nextInt(this.members.size()));
        Mockito.doNothing().when(this.memberService).save(Mockito.any(Member.class));

        String reqBody = new ObjectMapper().writeValueAsString(newMember);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/rest/members")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content(reqBody))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        Mockito.verify(this.memberService, Mockito.times(1))
                .save(Mockito.any(Member.class));
    }

    @Test
    void findMemberById() throws Exception {
        Mockito.when(this.memberService.findById(Mockito.any(Long.class)))
                .thenReturn(this.memberOne);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/members/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(this.memberOne.getId()));
        Mockito.verify(this.memberService, Mockito.times(1))
                .findById(Mockito.any(Long.class));
    }

    @Test
    void deleteMember() throws Exception {
        Mockito.doNothing().when(this.memberService).deleteById(Mockito.any(Long.class));

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/rest/members/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        Mockito.verify(this.memberService, Mockito.times(1))
                .deleteById(Mockito.any(Long.class));
    }
}
