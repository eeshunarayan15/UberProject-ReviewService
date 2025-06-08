package com.eeshu.uberreviewservice.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DriverRequest {
    private List<Long> driverIds;
}
