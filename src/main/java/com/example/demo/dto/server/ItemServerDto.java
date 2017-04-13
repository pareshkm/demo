package com.example.demo.dto.server;


public class ItemServerDto {
	private String tcin;
	private BundleComponentsServerDto bundle_components;
	private String dpci;
	private String upc;
	private ProductDescriptionServerDto product_description;
	private String parent_items;
	private String buy_url;
	private ErichmentServerDto enrichment;
	private String return_method;
	private HandlingServerDto handling;
	private RecallComplianceServerDto recall_compliance;
	private TaxCategoryServerDto tax_category;
	private DisplayOptionServerDto display_option;
	private FulfillmentServerDto fulfillment;
	private PackageDimensionsServerDto package_dimensions;
	private EnvironmentalSegmentationServerDto environmental_segmentation;
	private ManufacturerServerDto manufacturer;
	private ProductClassificationServerDto product_classification;
	private ProductBrandServerDto product_brand;
	private String item_state;
	private SpecificationServerDto[] specifications;
	private AttributesServerDto attributes;
	private String country_of_origin;
	private String relationship_type_code;
	private boolean subscription_eligible;
	private String estore_item_status_code;	
	private Object return_policies;
	
	public String getTcin() {
		return tcin;
	}
	public void setTcin(String tcin) {
		this.tcin = tcin;
	}
	public BundleComponentsServerDto getBundle_components() {
		return bundle_components;
	}
	public void setBundle_components(BundleComponentsServerDto bundle_components) {
		this.bundle_components = bundle_components;
	}
	public String getDpci() {
		return dpci;
	}
	public void setDpci(String dpci) {
		this.dpci = dpci;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public ProductDescriptionServerDto getProduct_description() {
		return product_description;
	}
	public void setProduct_description(
			ProductDescriptionServerDto product_description) {
		this.product_description = product_description;
	}
	public String getParent_items() {
		return parent_items;
	}
	public void setParent_items(String parent_items) {
		this.parent_items = parent_items;
	}
	public String getBuy_url() {
		return buy_url;
	}
	public void setBuy_url(String buy_url) {
		this.buy_url = buy_url;
	}
	public ErichmentServerDto getEnrichment() {
		return enrichment;
	}
	public void setEnrichment(ErichmentServerDto enrichment) {
		this.enrichment = enrichment;
	}
	public String getReturn_method() {
		return return_method;
	}
	public void setReturn_method(String return_method) {
		this.return_method = return_method;
	}
	public HandlingServerDto getHandling() {
		return handling;
	}
	public void setHandling(HandlingServerDto handling) {
		this.handling = handling;
	}
	public RecallComplianceServerDto getRecall_compliance() {
		return recall_compliance;
	}
	public void setRecall_compliance(RecallComplianceServerDto recall_compliance) {
		this.recall_compliance = recall_compliance;
	}
	public TaxCategoryServerDto getTax_category() {
		return tax_category;
	}
	public void setTax_category(TaxCategoryServerDto tax_category) {
		this.tax_category = tax_category;
	}
	public DisplayOptionServerDto getDisplay_option() {
		return display_option;
	}
	public void setDisplay_option(DisplayOptionServerDto display_option) {
		this.display_option = display_option;
	}
	public FulfillmentServerDto getFulfillment() {
		return fulfillment;
	}
	public void setFulfillment(FulfillmentServerDto fulfillment) {
		this.fulfillment = fulfillment;
	}
	public PackageDimensionsServerDto getPackage_dimensions() {
		return package_dimensions;
	}
	public void setPackage_dimensions(PackageDimensionsServerDto package_dimensions) {
		this.package_dimensions = package_dimensions;
	}
	public EnvironmentalSegmentationServerDto getEnvironmental_segmentation() {
		return environmental_segmentation;
	}
	public void setEnvironmental_segmentation(
			EnvironmentalSegmentationServerDto environmental_segmentation) {
		this.environmental_segmentation = environmental_segmentation;
	}
	public ManufacturerServerDto getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(ManufacturerServerDto manufacturer) {
		this.manufacturer = manufacturer;
	}
	public ProductClassificationServerDto getProduct_classification() {
		return product_classification;
	}
	public void setProduct_classification(
			ProductClassificationServerDto product_classification) {
		this.product_classification = product_classification;
	}
	public ProductBrandServerDto getProduct_brand() {
		return product_brand;
	}
	public void setProduct_brand(ProductBrandServerDto product_brand) {
		this.product_brand = product_brand;
	}
	public String getItem_state() {
		return item_state;
	}
	public void setItem_state(String item_state) {
		this.item_state = item_state;
	}
	public SpecificationServerDto[] getSpecifications() {
		return specifications;
	}
	public void setSpecifications(SpecificationServerDto[] specifications) {
		this.specifications = specifications;
	}
	public AttributesServerDto getAttributes() {
		return attributes;
	}
	public void setAttributes(AttributesServerDto attributes) {
		this.attributes = attributes;
	}
	public String getCountry_of_origin() {
		return country_of_origin;
	}
	public void setCountry_of_origin(String country_of_origin) {
		this.country_of_origin = country_of_origin;
	}
	public String getRelationship_type_code() {
		return relationship_type_code;
	}
	public void setRelationship_type_code(String relationship_type_code) {
		this.relationship_type_code = relationship_type_code;
	}
	public boolean isSubscription_eligible() {
		return subscription_eligible;
	}
	public void setSubscription_eligible(boolean subscription_eligible) {
		this.subscription_eligible = subscription_eligible;
	}
	public String getEstore_item_status_code() {
		return estore_item_status_code;
	}
	public void setEstore_item_status_code(String estore_item_status_code) {
		this.estore_item_status_code = estore_item_status_code;
	}
	public Object getReturn_policies() {
		return return_policies;
	}
	public void setReturn_policies(Object return_policies) {
		this.return_policies = return_policies;
	}
}
