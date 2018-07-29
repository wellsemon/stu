## @Jsonview
标记字段是否参与（反）序列化，形成多种数据视图
* 未标记字段不受影响
* 每种数据视图，初始都应设置标记
    * 
    * 若视图存在固定父子关系，可 extends
    * 子视图比父视图大
* 标记 field
    * 标记 getter 有效，setter 无效

* 注解可包括多个 标记
* 每个字段都必须标记
* SpringMvc 默认使用 jackson，支持此注解
* 标记 field 是对象类型
    * 被标记对象内，可用不同标记进行过滤不需要的字段
    
## extends PropertyFilter
### 流程
> 序列化对象标记 @JsonFilter("id")  
> 自定义 PropertyFilter，绑定到 FilterProvider  
> FilterProvider 标识与 @JsonFilter 一致  
> 绑定到 ObjectMapper
### 特性
* 支持自定义 PropertyFilter
* 自动遍历各个层级的所有属性
* 递归过滤时，每个类上都需 @JsonFilter("同一标识")
* 定义接口，增加 @JsonFilter 注解，并调用 ObjectMapper.addMixIn(Target.class,Interface.class) 绑定注解到目标类，目标类与注解解耦
### 实例
* 对象属性不满足条件时，该对象不参与序列化

## extends StdSerializer
自定义序列化逻辑
* module.addSerializer(Target.class, CustomSerializer)
* ObjectMapper.registerModule