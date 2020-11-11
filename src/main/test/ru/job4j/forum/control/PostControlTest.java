package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class PostControlTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostService posts;

    @Test
    @WithMockUser
    public void whenCreateMappingMethodGet() throws Exception {
        this.mockMvc.perform(get("/create"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("post/create"));
    }



    @Test
    @WithMockUser
    public void whenCreatePostShouldReturnDefaultMessage() throws Exception {
        Post post = new Post();
        post.setName("new name");
        post.setDescription("new description");
        this.mockMvc.perform(post("/save")
            .param("name",post.getName())
            .param("description", post.getDescription())
        )
            .andDo(print())
            .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(posts).create(argument.capture());
        assertThat(argument.getValue().getName(), is("new name"));

    }

    @Test
    @WithMockUser
    public void whenEditMappingMethodGet() throws Exception {
        this.mockMvc.perform(get("/edit")
            .param("id", "1"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("post/edit"));
    }

    @Test
    @WithMockUser
    public void whenEditUserMethodPost() throws Exception {
        Post post = new Post();
        post.setName("new name");
        post.setDescription("new description");
        this.mockMvc.perform(post("/edit")
            .param("name", post.getName())
            .param("description", post.getDescription())
            )
            .andDo(print())
            .andExpect(status().is3xxRedirection());
        verify(posts).update(post);
    }
}