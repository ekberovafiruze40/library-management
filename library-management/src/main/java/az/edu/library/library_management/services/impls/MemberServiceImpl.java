package az.edu.library.library_management.services.impls;

import az.edu.library.library_management.dtos.member.MemberCreateDto;
import az.edu.library.library_management.dtos.member.MemberResponseDto;
import az.edu.library.library_management.dtos.member.MemberUpdateDto;
import az.edu.library.library_management.models.Member;
import az.edu.library.library_management.repositories.MemberRepository;
import az.edu.library.library_management.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<MemberResponseDto> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(member -> modelMapper.map(member, MemberResponseDto.class))
                .collect(Collectors.toList());    }

    @Override
    public MemberResponseDto getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        return modelMapper.map(member, MemberResponseDto.class);    }

    @Override
    public MemberResponseDto createMember(MemberCreateDto createDto) {
        Member member = modelMapper.map(createDto, Member.class);
        Member savedMember = memberRepository.save(member);
        return modelMapper.map(savedMember, MemberResponseDto.class);    }

    @Override
    public MemberResponseDto updateMember(Long id, MemberUpdateDto updateDto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));

        modelMapper.map(updateDto, member);
        Member updatedMember = memberRepository.save(member);
        return modelMapper.map(updatedMember, MemberResponseDto.class);    }

    @Override
    public void deleteMember(Long id) {

        if (!memberRepository.existsById(id)) {
            throw new RuntimeException("Member not found with id: " + id);
        }
        memberRepository.deleteById(id);
    }
}
