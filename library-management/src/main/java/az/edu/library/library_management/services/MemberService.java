package az.edu.library.library_management.services;

import az.edu.library.library_management.dtos.member.MemberCreateDto;
import az.edu.library.library_management.dtos.member.MemberResponseDto;
import az.edu.library.library_management.dtos.member.MemberUpdateDto;

import java.util.List;

public interface MemberService {
    List<MemberResponseDto> getAllMembers();
    MemberResponseDto getMemberById(Long id);
    MemberResponseDto createMember(MemberCreateDto createDto);
    MemberResponseDto updateMember(Long id, MemberUpdateDto updateDto);
    void deleteMember(Long id);
}
