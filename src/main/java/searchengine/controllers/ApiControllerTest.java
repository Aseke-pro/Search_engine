package searchengine.controllers;

import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import searchengine.dto.Indexing.IndexingResponse;
import searchengine.dto.search.SearchResponse;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.services.interfaces.IndexingService;
import searchengine.services.interfaces.SearchService;
import searchengine.services.interfaces.StatisticsService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ApiController.class)
class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IndexingService indexingService;

    @MockBean
    private StatisticsService statisticsService;

    @MockBean
    private SearchService searchService;

    @Test
    void testStartIndexing() throws Exception {
        when(indexingService.startIndexing()).thenReturn(new IndexingResponse(true, "Индексация запущена"));
        mockMvc.perform(get("/api/startIndexing"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true))
                .andExpect(jsonPath("$.message").value("Индексация запущена"));
    }

    @Test
    void testStopIndexing() throws Exception {
        when(indexingService.stopIndexing()).thenReturn(new IndexingResponse(true, "Индексация остановлена"));
        mockMvc.perform(get("/api/stopIndexing"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true))
                .andExpect(jsonPath("$.message").value("Индексация остановлена"));
    }

    @Test
    void testDeleteDatabase() throws Exception {
        when(indexingService.deleteDataBase()).thenReturn(new IndexingResponse(true, "База данных удалена"));
        mockMvc.perform(post("/api/deleteDataBase"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true))
                .andExpect(jsonPath("$.message").value("База данных удалена"));
    }

    @Test
    void testIndexPage() throws Exception {
        String url = "http://example.com";
        when(indexingService.indexPage(url)).thenReturn(new IndexingResponse(true, "Страница проиндексирована"));
        mockMvc.perform(post("/api/indexPage").contentType(MediaType.APPLICATION_JSON).content(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true))
                .andExpect(jsonPath("$.message").value("Страница проиндексирована"));
    }
}
