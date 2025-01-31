package searchengine.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import searchengine.dto.Indexing.IndexingResponse;
import searchengine.dto.search.SearchResponse;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.services.interfaces.IndexingService;
import searchengine.services.interfaces.SearchService;
import searchengine.services.interfaces.StatisticsService;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final IndexingService indexingService;
    private final StatisticsService statisticsService;
    private final SearchService searchService;

    public ApiController(StatisticsService statisticsService, IndexingService indexingService, SearchService searchService) {
        this.statisticsService = statisticsService;
        this.indexingService = indexingService;
        this.searchService = searchService;
    }

    @GetMapping("/startIndexing")
    public ResponseEntity<IndexingResponse> startIndexing() {
        try {
            return ResponseEntity.ok(indexingService.startIndexing());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new IndexingResponse(false, "Ошибка при запуске индексации: " + e.getMessage()));
        }
    }

    @GetMapping("/stopIndexing")
    public ResponseEntity<IndexingResponse> stopIndexing() {
        try {
            return ResponseEntity.ok(indexingService.stopIndexing());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new IndexingResponse(false, "Ошибка при остановке индексации: " + e.getMessage()));
        }
    }

    @PostMapping("/deleteDataBase")
    public ResponseEntity<IndexingResponse> deleteDataBase() {
        try {
            return ResponseEntity.ok(indexingService.deleteDataBase());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new IndexingResponse(false, "Ошибка при удалении базы данных: " + e.getMessage()));
        }
    }

    @PostMapping("/indexPage")
    public ResponseEntity<IndexingResponse> indexPage(@RequestBody String url) {
        try {
            return ResponseEntity.ok(indexingService.indexPage(url));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new IndexingResponse(false, "Ошибка при индексации страницы: " + e.getMessage()));
        }
    }

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsResponse> statistics() {
        try {
            return ResponseEntity.ok(statisticsService.getStatistics());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<SearchResponse> search(@RequestParam String query, @RequestParam int offset, @RequestParam int limit, @RequestParam(required = false) String site) {
        try {
            return ResponseEntity.ok(searchService.search(query, offset, limit, site));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new SearchResponse(false, "Ошибка при выполнении поиска: " + e.getMessage()));
        }
    }
}
