package az.edu.library.library_management.controllers;

import az.edu.library.library_management.dtos.member.MemberCreateDto;
import az.edu.library.library_management.dtos.member.MemberResponseDto;
import az.edu.library.library_management.dtos.member.MemberUpdateDto;
import az.edu.library.library_management.services.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MembersController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> getAllMembers() {
        List<MemberResponseDto> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMemberById(@PathVariable Long id) {
        MemberResponseDto member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@Valid @RequestBody MemberCreateDto createDto) {
        MemberResponseDto createdMember = memberService.createMember(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long id,
                                                          @RequestBody MemberUpdateDto updateDto) {
        MemberResponseDto updatedMember = memberService.updateMember(id, updateDto);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
