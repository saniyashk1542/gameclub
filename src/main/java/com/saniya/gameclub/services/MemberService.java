package com.saniya.gameclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saniya.gameclub.exceptions.IdNotPresentException;
import com.saniya.gameclub.modal.Member;
import com.saniya.gameclub.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repo;

    public Member create(Member member) {
        member.setId(null);
        return repo.save(member);
    }

    public List<Member> findAll() {
        return repo.findAll();
    }

    public Member findById(String id) throws IdNotPresentException {
        Optional<Member> optionalMember = repo.findById(id);
        if (optionalMember.isEmpty()) {
            throw new IdNotPresentException("Member not found " + id);
        }
        return optionalMember.get();
    }

    public Member update(String id, Member member) throws IdNotPresentException {
        Optional<Member> optionalMember = repo.findById(id);
        if (optionalMember.isEmpty()) {
            throw new IdNotPresentException("Member not found " + id);
        }
        Member oldMember = optionalMember.get();
        oldMember.setName(member.getName());
        oldMember.setPhoneNumber(member.getPhoneNumber());
        oldMember.setBalance(member.getBalance());

        return repo.save(oldMember);
    }

    public boolean delete(String id) throws IdNotPresentException {
        Optional<Member> optionalMember = repo.findById(id);
        if (optionalMember.isEmpty()) {
            throw new IdNotPresentException("Member not found " + id);
        }
        repo.deleteById(id);
        return true;
    }
}