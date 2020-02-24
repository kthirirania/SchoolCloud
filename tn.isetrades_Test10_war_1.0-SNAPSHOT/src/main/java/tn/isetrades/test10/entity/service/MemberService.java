package tn.isetrades.test10.entity.service;

import java.util.List;
import tn.isetrades.test10.entity.dao.MemberDao;
import tn.isetrades.test10.entity.model.Member;
import tn.isetrades.test10.entity.model.Role;

/**
 *
 * @author Rania
 */
public class MemberService {
    
    MemberDao memberDAO = new MemberDao();

    public Member createMember(Member r) {
        memberDAO.addMember(r);
        return r;
    }

    public void updateMember(Integer id, String fname) {
        Member member = memberDAO.findMemberById(id);
        member.setFirstname(fname);
        memberDAO.updateMember(member);
    }
    
    public void updateMemberFull(Member m) {
        memberDAO.updateMember(m);
    }
    
    public void setMemberRole(Integer id, Integer id1) {
        Member member = memberDAO.findMemberById(id);
        Role role = new Role(id1);
        member.setRole(role);
        memberDAO.updateMember(member);
    }

    public void deleteMember(Integer id) {
        memberDAO.deleteMember(id);
    }

    public List<Member> getMemberList() {
        return memberDAO.listMember();
    }

    public Member getMember(Integer id) {
        return memberDAO.findMemberById(id);
    }
    
    public void enableorDisableMember(int id, boolean res){
        memberDAO.EnableOrDisableMember(id, res);
    }
    
    public boolean getStatus(int id){
        return memberDAO.getStatus(id);
    }
    
    public void addSToC(int id1, int id2){
        memberDAO.addStudentToCourse(id1, id2);
    }
    
}
