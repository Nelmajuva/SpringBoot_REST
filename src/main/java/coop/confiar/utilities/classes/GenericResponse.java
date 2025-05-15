package coop.confiar.utilities.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponse<TEntity> {
    private int statusCode;
    private TEntity message;
}
