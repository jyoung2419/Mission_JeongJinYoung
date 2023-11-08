package com.ll;

import lombok.Getter;
import lombok.Setter;

public class Quotation {
    @Getter
    int contentId;
    @Getter
    @Setter
    String content;
    @Getter
    @Setter
    String authorName;

    public Quotation(int contentId, String content, String authorName) {
        this.contentId = contentId;
        this.content = content;
        this.authorName = authorName;
    }
}