package org.cl.member.service.api;


import org.cl.member.entity.vo.ProjectVO;

public interface ProjectService {

	void saveProject(ProjectVO projectVO, Integer memberId);

}
