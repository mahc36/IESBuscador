package bussiness.program;

import java.util.List;

import dto.ProgramsFilterDTO;

public interface IProgramBussiness {
	public List<ProgramsFilterDTO> filter();
}