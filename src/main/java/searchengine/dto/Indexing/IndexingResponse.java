package searchengine.dto.Indexing;

import lombok.Data;

@Data
public class IndexingResponse {
    private boolean result;
    private String error;

    public IndexingResponse(boolean b, String s) {
    }
}