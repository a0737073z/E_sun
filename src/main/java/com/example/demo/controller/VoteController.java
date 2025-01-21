package com.example.demo.controller;

import com.example.demo.entity.VoteItem;
import com.example.demo.entity.VoteRecord;
import com.example.demo.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/votes")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @GetMapping("/items")
    public List<VoteItem> getAllVoteItems() {
        return voteService.getAllVoteItems();
    }

    @PostMapping("/items")
    public VoteItem addVoteItem(@jakarta.validation.Valid @RequestBody VoteItem voteItem) {
        validateVoteItem(voteItem); 
        return voteService.addVoteItem(voteItem);
    }

    @PostMapping("/vote")
    public void vote(@jakarta.validation.Valid @RequestBody VoteRecord voteRecord) {
        validateVoteRecord(voteRecord); 
        voteService.vote(voteRecord);
    }

    // 驗證 VoteItem
    private void validateVoteItem(VoteItem voteItem) {
        if (voteItem.getName() == null || voteItem.getName().isEmpty()) {
            throw new IllegalArgumentException("VoteItem name cannot be null or empty");
        }
    }


    private void validateVoteRecord(VoteRecord voteRecord) {

    }
}