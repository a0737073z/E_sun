package com.example.demo.service;

import com.example.demo.entity.VoteItem;
import com.example.demo.entity.VoteRecord;
import com.example.demo.repository.VoteItemRepository;
import com.example.demo.repository.VoteRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    @Autowired
    private VoteItemRepository voteItemRepository;

    @Autowired
    private VoteRecordRepository voteRecordRepository;

    public List<VoteItem> getAllVoteItems() {
        return voteItemRepository.findAll();
    }

    public VoteItem addVoteItem(VoteItem voteItem) {
        return voteItemRepository.save(voteItem);
    }

    public void vote(VoteRecord voteRecord) {
        voteRecordRepository.save(voteRecord);
    }
}
