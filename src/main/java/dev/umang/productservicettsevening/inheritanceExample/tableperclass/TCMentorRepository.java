package dev.umang.productservicettsevening.inheritanceExample.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TCMentorRepository extends JpaRepository<Mentor,Long> {
    Mentor save(Mentor mentor);
    Mentor findMentorById(Long id);
}
