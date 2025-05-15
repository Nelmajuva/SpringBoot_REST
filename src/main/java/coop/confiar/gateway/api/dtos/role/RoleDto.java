package coop.confiar.gateway.api.dtos.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private int Id;
    private String Name;
    private boolean Status;
}
