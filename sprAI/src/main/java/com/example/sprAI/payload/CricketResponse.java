package com.example.sprAI.payload;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CricketResponse {
    private String content;

    public String getContent() {
        return content;
    }
    public void setContent(String content)
    {
        this.content=content;
    }

}


