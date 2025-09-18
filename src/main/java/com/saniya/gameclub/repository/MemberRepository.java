package com.saniya.gameclub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.saniya.gameclub.modal.Member;

public interface MemberRepository extends MongoRepository<Member, String> {
}