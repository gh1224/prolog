package kit.prolog.dto;

import com.querydsl.jpa.impl.JPAQuery;
import kit.prolog.domain.Code;
import kit.prolog.domain.Image;
import kit.prolog.domain.Layout;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

/*
 * PostDetailDto를 위한 부분 DTO
 * */
@Getter
@Setter
@ToString
public class LayoutDto {
    private Long id;
    private int dtype;
    private double coordinateX;
    private double coordinateY;
    private double width;
    private double height;
    private String explanation;
    private String content;

    private List<String> url;
    private List<String> codes;

    // PostPreviewDto 하위 DTO
    public LayoutDto(Long id, int dtype) {
        this.id = id;
        this.dtype = dtype;
    }

    // 게시글 작성 API
    public LayoutDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    // 레이아웃 틀 하위 레이아웃 리스트 조회 API
    public LayoutDto(Long id, int dtype, double coordinateX, double coordinateY, double width, double height) {
        this.id = id;
        this.dtype = dtype;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.width = width;
        this.height = height;
    }

    // 레이아웃 작성 API
    public LayoutDto(int dtype, double coordinateX, double coordinateY, double width, double height) {
        this.dtype = dtype;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.width = width;
        this.height = height;
    }

    // 레이아웃 작성 service layer
    public LayoutDto(Layout layout){
        this.dtype = layout.getDtype();
        this.coordinateX = layout.getCoordinateX();
        this.coordinateY = layout.getCoordinateY();
        this.width = layout.getWidth();
        this.height = layout.getHeight();
    }

    // 레이아웃 가져오기
    public LayoutDto(String content) {
        this.content = content;
    }
    public LayoutDto(Code code) {
        this.codes = List.of(code.getCode(), code.getCodeExplanation(), code.getCodeType().toString());
    }
    public LayoutDto(List<String> url) {
        this.url = url;
    }
    public void addContent(LayoutDto layoutDto){
        this.content = layoutDto.getContent() == null ? null : layoutDto.getContent();
        this.codes = layoutDto.getCodes() == null ? null : layoutDto.getCodes();
        this.url = layoutDto.getUrl() == null ? null : layoutDto.getUrl();
    }
}
