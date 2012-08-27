package com.openrest.v1_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Restaurant chain information.
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Chain extends Organization {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
    public Chain() {}
    
    public Chain(String id, Map<String, String> externalIds, Long created, Long modified, String distributorId,
    		Map<String, String> title, Map<String, String> description,
    		String locale, Set<String> locales, ColorScheme colorScheme,
    		Contact contact, Map<String, Contact> externalContacts, Address address, String timezone,
    		String link, String domain, Set<String> altDomains,
    		List<AppInfo> apps, Seo seo, Map<String, String> properties,
    		String picture, String icon, String noImagePicture) {
    	super(id, externalIds, created, modified, title, description, locale, locales, colorScheme,
    			contact, externalContacts, address, timezone, link, domain, altDomains, apps, seo, properties,
    			picture, icon, noImagePicture);
    	
    	this.distributorId = distributorId;
    }
    
    @Override
	public Object clone() {
    	final List<AppInfo> clonedApps;
    	if (apps != null) {
    		clonedApps = new ArrayList<AppInfo>(apps.size());
    		for (AppInfo app : apps) {
    			clonedApps.add((AppInfo) app.clone());
    		}
    	} else {
    		clonedApps = null;
    	}
    	
    	final Map<String, Contact> clonedExternalContacts;
    	if (externalContacts != null) {
    		clonedExternalContacts = new LinkedHashMap<String, Contact>(externalContacts.size());
    		for (Entry<String, Contact> entry : externalContacts.entrySet()) {
    			clonedExternalContacts.put(entry.getKey(), (Contact) entry.getValue().clone());
    		}
    	} else {
    		clonedExternalContacts = null;
    	}    	
    	
    	return new Chain(id,
    			((externalIds != null) ? new HashMap<String, String>(externalIds) : null),
    			created, modified, distributorId,
    			((title != null) ? new HashMap<String, String>(title) : null),
    			((description != null) ? new HashMap<String, String>(description) : null),
    			locale,
    			((locales != null) ? new HashSet<String>(locales) : null),
    			((colorScheme != null) ? (ColorScheme)colorScheme.clone() : null),
    			((contact != null) ? (Contact) contact.clone() : null), clonedExternalContacts,
    			((address != null) ? (Address) address.clone() : null),
    			timezone, link, domain,
    			((altDomains != null) ? new HashSet<String>(altDomains) : null),
    			clonedApps,
    			((seo != null) ? (Seo) seo.clone() : null),
    			((properties != null) ? new HashMap<String, String>(properties) : null),
    			picture, icon, noImagePicture);
	}
    
    /** The distributor in charge of this chain. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String distributorId;
}