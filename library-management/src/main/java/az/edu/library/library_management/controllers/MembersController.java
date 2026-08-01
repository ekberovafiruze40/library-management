package az.edu.library.library_management.controllers;

import az.edu.library.library_management.dtos.member.MemberCreateDto;
import az.edu.library.library_management.dtos.member.MemberResponseDto;
import az.edu.library.library_management.dtos.member.MemberUpdateDto;
import az.edu.library.library_management.services.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Tag(name = "Member Management", description = "Endpoints for managing library members")
public class MembersController {

    private final MemberService memberService;

    @GetMapping
    @Operation(summary = "Get all members", description = "Retrieves a list of all library members")
    @ApiResponse(responseCode = "200", description = "Member list successfully retrieved")
    public ResponseEntity<List<MemberResponseDto>> getAllMembers() {
        List<MemberResponseDto> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get member by ID", description = "Retrieves member details by their unique ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Member successfully found"),
            @ApiResponse(responseCode = "404", description = "Member not found")
    })
    public ResponseEntity<MemberResponseDto> getMemberById(@PathVariable Long id) {
        MemberResponseDto member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    @PostMapping
    @Operation(summary = "Create a new member", description = "Registers a new library member")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Member successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid or missing input data")
    })
    public ResponseEntity<MemberResponseDto> createMember(@Valid @RequestBody MemberCreateDto createDto) {
        MemberResponseDto createdMember = memberService.createMember(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a member", description = "Updates an existing member's information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Member successfully updated"),
            @ApiResponse(responseCode = "404", description = "Member not found")
    })
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long id,
                                                          @RequestBody MemberUpdateDto updateDto) {
        MemberResponseDto updatedMember = memberService.updateMember(id, updateDto);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a member", description = "Removes a member from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Member successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Member not found")
    })
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
