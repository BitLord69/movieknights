package com.movieknights.server.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("MKDBSetting")
public class DBSetting {

    @Id
    private LocalDate lastUpdated;

    private Long numberOfLines;
    private Long lastIndex;
}
